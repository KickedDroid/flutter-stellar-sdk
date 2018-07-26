# Saturn Flutter SDK
![alt text](https://preview.ibb.co/iL8VUT/planet.png)

The Saturn open source SDK for ios and android using Flutter.

## Generate a Stellar KeyPair
```dart
Saturnpackage.stellarKeyPairSeed(String seed);
```
## Create a Stellar account with FriendBot
```dart
Saturnpackage.stellarCreateTestAccount(dynamic accountPair);
```
## Build and submit a TX to the stellar network
```dart
Saturnpackage.submitStellarTx(String destination, String source, String amount);
// Amount is in string format not a double
```
