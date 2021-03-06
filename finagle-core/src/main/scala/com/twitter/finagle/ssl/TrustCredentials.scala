package com.twitter.finagle.ssl

import java.io.File

/**
 * TrustCredentials represent the items necessary for this configured
 * TLS [[Engine]] to verify a remote peer's credentials.
 */
private[ssl] sealed trait TrustCredentials

private[ssl] object TrustCredentials {

  /**
   * Indicates that the trust credentials to use with a particular
   * engine should be delegated to the engine factory, or that none
   * are necessary.
   */
  case object Unspecified extends TrustCredentials

  /**
   * Indicates that a remote peer's credentials should not be
   * verified. This value is not recommended for use outside of
   * development and testing.
   */
  case object Insecure extends TrustCredentials

  /**
   * The collection of certificates which should be used in
   * verifying a remote peer's credentials.
   *
   * @file A file containing a collection of X.509 certificates
   * in PEM format.
   */
  case class CertCollection(file: File) extends TrustCredentials
}
