To run this, first 

```
docker run -p5432:5432 -d tpolecat/skunk-world
```

(This is the same container used in the skunk microsite example)


And then `sbt run` should result in:

```
[info] running Hello 
[error] skunk.exception.PostgresErrorException: 
[error] 🔥  
[error] 🔥  Postgres ERROR 34000 raised in exec_execute_message (postgres.c:1917)
[error] 🔥  
[error] 🔥    Problem: Portal "portal_3" does not exist.
[error] 🔥  
[error] 🔥  The statement under consideration was defined
[error] 🔥    at /home/luciano/src/skunk-portals/Main.scala:27
[error] 🔥  
[error] 🔥    select current_date
[error] 🔥  
[error] 🔥  If this is an error you wish to trap and handle in your application, you can do
[error] 🔥  so with a SqlState extractor. For example:
[error] 🔥  
[error] 🔥    doSomething.recoverWith { case SqlState.InvalidCursorName(ex) =>  ...}
[error] 🔥  
[error] 
[error] skunk.exception.PostgresErrorException: Portal "portal_3" does not exist.
[error] 	at skunk.net.protocol.Unroll.$anonfun$unroll$1(Unroll.scala:66)
[error] 	at flatten$extension @ skunk.util.Pool$.$anonfun$ofF$2(Pool.scala:103)
[error] 	at flatMap @ skunk.net.BufferedMessageSocket$$anon$1.$anonfun$receive$1(BufferedMessageSocket.scala:150)
[error] 	at get @ skunk.util.Pool$.free$1(Pool.scala:156)
[error] 	at flatMap @ skunk.net.BufferedMessageSocket$$anon$1.receive(BufferedMessageSocket.scala:147)
[error] stack trace is suppressed; run last Compile / run for the full output
[error] (Compile / run) skunk.exception.PostgresErrorException: 
[error] 🔥  
[error] 🔥  Postgres ERROR 34000 raised in exec_execute_message (postgres.c:1917)
[error] 🔥  
[error] 🔥    Problem: Portal "portal_3" does not exist.
[error] 🔥  
[error] 🔥  The statement under consideration was defined
[error] 🔥    at /home/luciano/src/skunk-portals/Main.scala:27
[error] 🔥  
[error] 🔥    select current_date
[error] 🔥  
[error] 🔥  If this is an error you wish to trap and handle in your application, you can do
[error] 🔥  so with a SqlState extractor. For example:
[error] 🔥  
[error] 🔥    doSomething.recoverWith { case SqlState.InvalidCursorName(ex) =>  ...}
[error] 🔥  
[error] 
[error] skunk.exception.PostgresErrorException: Portal "portal_3" does not exist.
[error] Total time: 7 s, completed 26 Jun 2023, 17:28:04
```
