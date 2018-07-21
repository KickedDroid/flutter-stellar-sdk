package com.example.saturnpackage;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import java.security.KeyPair;
import java.util.HashMap;
import java.net.*;
import java.io.*;
import java.util.*;

import com.sun.java.util.jar.pack.Package.Class.Method;
import com.sun.org.apache.xpath.internal.operations.String;

import org.stellar.sdk;
import org.stellar.sdk.KeyPair;
import org.stellar.sdk.Server;
import org.stellar.sdk.responses.AccountResponse;

/** SaturnpackagePlugin */
public class SaturnpackagePlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "saturnpackage");
    channel.setMethodCallHandler(new SaturnpackagePlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    try {
      switch (call.method) {
      case "stellar_keyPair_seed":
        stellar_keyPair_seed(call, result);
        break;
        case "stellar_create_test_account": stellar_create_test_account(call, result); break;
        case "get_account_details": get_account_details(call, result); break;
      default:
        result.notImplemented();
        break;
      }
    } catch (Exception error) {
      result.error("Error", call.method + " fails with " + error.getMessage(), null);
    }
  }

  // Generate a Stellar KeyPair
  private void stellar_keyPair_seed(MethodCall call, Result result) throws Exception {
    KeyPair pair = KeyPair.random();

    HashMap map = new HashMap<>();
    map.put("pk", new String(pair.getPublic()));
    map.put("sk", new String(pair.getPrivate()));
    result.success(map);
  }

  // Create a Stellar account with FriendBot 
  private void stellar_create_test_account(MethodCall call, Result result) throws Exception {
    String friendbotUrl = String.format("https://friendbot.stellar.org/?addr=%s", pair.getAccountId());
    InputStream response = new URL(friendbotUrl).openStream();
    String body = new Scanner(response, "UTF-8").useDelimiter("\\A").next();
    result.success("SUCCESS! You have a new account :)\n" + body);
  }

  // Get Account details
  private void get_account_details(MethodCall call, Result result) throws Exception {
    Server server = new Server("https://horizon-testnet.stellar.org");
    AccountResponse account = server.accounts().account(pair);
    System.out.println("Balances for account " + pair.getAccountId());
    for (AccountResponse.Balance balance : account.getBalances()) {
      result.success(String.format("Type: %s, Code: %s, Balance: %s", balance.getAssetType(), balance.getAssetCode(),
          balance.getBalance()));
    }
  }

}
