import 'dart:async';

import 'package:flutter/services.dart';

class Saturnpackage {
  static const MethodChannel _channel =
      const MethodChannel('saturnpackage');

  // Build and submit a TX to the stellar network
  static Future<String>  submitStellarTx(String destination, String source, String amount) async {
    final String tx = await _channel.invokeMethod('submit_stellar_tx', {"destination":destination, "source":source, "amount":amount});
    print(tx);
    return tx;
  }

  // Generate a Stellar KeyPair
  static Future<String> stellarKeyPairSeed(String seed) async {
    final String keyPair = await _channel.invokeMethod('stellar_keyPair_seed', {"seed": seed});
    print(keyPair);
    return keyPair;
  }

  // Create a Stellar account with FriendBot
  static Future<String> stellarCreateTestAccount(String accountPair) async {
    final String result = await _channel.invokeMethod('stellar_create_test_account', {'accountpair': accountPair});
    print(result);
    return result;
  }


}
