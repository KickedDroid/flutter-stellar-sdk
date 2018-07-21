import 'dart:async';

import 'package:flutter/services.dart';

class Saturnpackage {
  static const MethodChannel _channel =
      const MethodChannel('saturnpackage');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
