# LINE Notify

[LINE Notify](https://engineering.linecorp.com/ja/blog/using-line-notify-to-send-messages-to-line-from-the-command-line/) のCLIクライアントです。

## インストール

```shell
brew tap kijuky/tools
brew install line-notify
```

## 使い方

[LINE Notify のマイページ](https://notify-bot.line.me/my/)からパーソナルアクセストークンを取得し、送信メッセージと共に実行します。

```shell
line-notify --token $PERSONAL_ACCESS_TOKEN message
```

アクセスが成功した場合、[Preferences](https://docs.oracle.com/en/java/javase/19/core/preferences-api1.html) にパーソナルアクセストークンをキャッシュするため、以降はアクセストークンを省略できます。

```shell
line-notify message2
```
