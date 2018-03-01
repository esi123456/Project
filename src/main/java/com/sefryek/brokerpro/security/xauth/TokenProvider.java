package com.sefryek.brokerpro.security.xauth;

public class TokenProvider {

    private final String secretKey;
    private final int tokenValidity;

    public TokenProvider(String secretKey, int tokenValidity) {
        this.secretKey = secretKey;
        this.tokenValidity = tokenValidity;
    }

    public String getSecretKey() {
        return secretKey;
//        String[] parts = authToken.split(":");
//        long expires = Long.parseLong(parts[1]);
//        String signature = parts[2];
//        String signatureToMatch = computeSignature(userDetails, expires);
//        return expires >= System.currentTimeMillis() && signature.equals(signatureToMatch);
    }

    public int getTokenValidity() {
        return tokenValidity;
    }


}
