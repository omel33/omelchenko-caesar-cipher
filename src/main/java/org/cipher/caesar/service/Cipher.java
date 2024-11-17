package org.cipher.caesar.service;

import java.util.List;

public interface Cipher {
    String encrypt(List<String> lines, int key);
    String decrypt(List<String> lines, int key);
}
