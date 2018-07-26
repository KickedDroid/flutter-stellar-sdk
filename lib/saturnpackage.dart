import 'dart:async';

import 'package:flutter/services.dart';

class Saturnpackage {
  static const MethodChannel _channel =
      const MethodChannel('saturnpackage');

  // Build and submit a TX to the stellar network
  static Future<String>  submitStellarTx(String destination, String source, String amount) async {
    final String tx = await _channel.invokeMethod('submit_stellar_tx', {"destination":destination, "source":source, "amount":amount});
    return tx;
  }

  // Generate a Stellar KeyPair
  static Future<String> stellarKeyPairSeed(dynamic seed) async {
    final String keyPair = await _channel.invokeMethod('stellar_keyPair_seed', {"seed": seed});
    return keyPair;
  }

  // Create a Stellar account with FriendBot
  static Future<String> stellarCreateTestAccount(dynamic accountPair) async {
    final String result = await _channel.invokeMethod('stellar_create_test_account', {'accountpair': accountPair});
    return result;
  }


}
