package org.cipher.caesar.io;
/*
For user interaction
 */
public interface Cli {
  /**
  * @param messageForUser - message without quotes
  * @return - input from user
   */
    String getUserInput(String messageForUser);

    /**
     *
     * @param message
     */
    void displayOutput(String message);
}
