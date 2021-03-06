/***************************************************
 * Licensed under MIT No Attribution (SPDX: MIT-0) *
 ***************************************************/

package org.reactivestreams.tck.flow.support;


/**
 * Copy of scala.control.util.NonFatal in order to not depend on scala-library
 */
public class NonFatal {
  private NonFatal() {
    // no instances, please.
  }

  /**
   * Returns true if the provided `Throwable` is to be considered non-fatal, or false if it is to be considered fatal
   *
   * @param t throwable to be matched for fatal-ness
   * @return true if is a non-fatal throwable, false otherwise
   */
  public static boolean isNonFatal(Throwable t) {
    if (t instanceof StackOverflowError) {
      // StackOverflowError ok even though it is a VirtualMachineError
      return true;
    } else if (t instanceof VirtualMachineError ||
        t instanceof ThreadDeath ||
        t instanceof InterruptedException ||
        t instanceof LinkageError) {
      // VirtualMachineError includes OutOfMemoryError and other fatal errors
      return false;
    } else {
      return true;
    }
  }
}
