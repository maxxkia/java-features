package jep395;

import java.util.Objects;

record FileInfo(String filename, long size) {

  FileInfo {
    // validations
    Objects.requireNonNull(filename, "filename cannot be null");
    if (size < 0) {
      throw new IllegalArgumentException("size cannot be negative");
    }

    // normalizations
    filename = filename.trim();
  }
}
