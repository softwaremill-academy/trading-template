package com.softwaremill.academy.trading.hello.infrastructure

import cats.Applicative
import cats.effect.Sync
import cats.syntax.all._
import com.softwaremill.academy.trading.hello.domain.HelloService
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

object HelloService {
  implicit def logger[F[_]: Sync] = Slf4jLogger.getLogger[F]

  def make[F[_]: Sync]: HelloService[F] = new HelloService[F] {

    override def hello(name: String): F[String] = Logger[F].info("Hello invoked") >> s"Hello, $name".pure
  }
}
