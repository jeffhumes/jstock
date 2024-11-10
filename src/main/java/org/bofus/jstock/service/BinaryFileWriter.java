package org.bofus.jstock.service;

import java.io.OutputStream;

public class BinaryFileWriter implements AutoCloseable {

  private final OutputStream outputStream;

  public BinaryFileWriter(OutputStream outputStream) {
    this.outputStream = outputStream;
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'close'");
  }
}
