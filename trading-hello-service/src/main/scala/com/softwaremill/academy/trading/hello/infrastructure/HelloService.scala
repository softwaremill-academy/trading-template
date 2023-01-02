package com.softwaremill.academy.trading.hello.infrastructure

import cats.Applicative
import cats.syntax.all._
import com.softwaremill.academy.trading.hello.domain.HelloService
import org.typelevel.log4cats.LoggerFactory

object HelloService {

  def make[F[_]: Applicative: LoggerFactory]: HelloService[F] = new HelloService[F] {
    val logger = LoggerFactory[F].getLogger
    override def hello(name: String): F[String] = logger.info("Hello invoked") *> s"Hello, $name".pure
  }
}
