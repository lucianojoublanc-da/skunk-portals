import cats.effect._
import skunk._
import skunk.implicits._
import skunk.codec.all._
import natchez.Trace.Implicits.noop
import fs2.Stream

object Hello extends IOApp {

  val session: Resource[IO, Session[IO]] =
    Session.single(
      host = "localhost",
      port = 5432,
      user = "jimmy",
      database = "world",
      password = Some("banana")
    )

  def run(args: List[String]): IO[ExitCode] =
    session.use { s =>
      Stream(makeQuery(s), makeQuery(s)).parJoinUnbounded.compile.drain
        .as(ExitCode.Success)
    }

  def makeQuery(session: Session[IO]) =
    for {
      p <- Stream.eval(session.prepare(sql"select current_date".query(date)))
      d <- p.stream(Void, 1)
    } yield ()
}
