import 'dart:async';

import 'package:flutter/services.dart';

class Saturnpackage {
  static const MethodChannel _channel =
      const MethodChannel('saturnpackage');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion', null);
    return version;
  }

  static Future<String>  submitStellarTx(String destination, String source, String amount) async {
    final String tx = await _channel.invokeMethod('submit_stellar_tx', {"destination":destination, "source":source, "amount":amount});
    return tx;
  }

}
