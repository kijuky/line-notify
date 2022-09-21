# LINE Notify

LINE NotifyのCLIクライアントです。

## インストール

TBD

## 使い方

LINE NotifyのMyページからパーソナルアクセストークンを取得し、送信メッセージと共に実行します。

```shell
line-notify --token $PERSONAL_ACCESS_TOKEN message
```

アクセスが成功した場合、preferences にパーソナルアクセストークンをキャッシュするため、以降はアクセストークンを省略できます。

```shell
line-notify message2
```
