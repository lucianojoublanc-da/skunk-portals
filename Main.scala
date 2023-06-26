import cats.effect._
import skunk._
import skunk.implicits._
import skunk.codec.all._
import natchez.Trace.Implicits.noop

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
      import cats.syntax.all._
      (makeQuery(s), makeQuery(s)).parMapN{ case _ => ExitCode.Success }
    }

  def makeQuery(session: Session[IO]) =
    for {
      p <- session.prepare(sql"select current_date".query(date))
      d <- p.unique(Void)
    } yield ()
}
