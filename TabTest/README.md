# TabSync Test in Java #
AndroidのTabLayoutとRecyclerViewの間の軽量な同期機能です。

この同期機能は、RecyclerViewのアイテムをスクロールすると対応するTabLayoutのアイテムが自動的に選択され、逆に、TabLayoutのアイテムを押すと、RecyclerViewが対応するアイテムまでスクロールして表示されます。

![Mediator attached](https://media.giphy.com/media/T1cDzfvY3KzQn7kp5d/giphy.gif)
![Mediator attached with smooth scroll](https://media.giphy.com/media/MTS4wKN5EenEqgCPw7/giphy.gif)

## チュートリアル ##
このレポートの例を順に説明した[記事](https://ahmad-hamwi.medium.com/synchronize-recyclerview-with-tablayout-3c5da4f3b18b)はこちらです。

## どうやってセットアップするか ##
Maven Central経由で最新版を取得します。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.ahmad-hamwi/tabsync/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.ahmad-hamwi/tabsync)

Gradleを使用する場合は、ルートのbuild.gradleのrepositoriesの最後にMaven Centralのリポジトリを追加してください。

```groovy
allprojects {
    repositories {
        ...
        mavenCentral()
    }
}
```

dependencyを追加

```groovy
dependencies {
    implementation 'io.github.ahmad-hamwi:tabsync:1.0.1'
}
```

## 使用方法 ##
ここでは、TabSync の基本的な使い方を説明します。
TabbedListMediator を作成し、RecyclerView、TabLayout、そしてタブを同期したい RecyclerView のアイテムのインデックスを渡します。
```java
mediator = new TabbedListMediator(
                recyclerView,
                tabLayout,
                indices
        )
```
RecyclerViewとTabLayoutがそれぞれのデータとともにインスタンス化されていることを確認し（RecyclerViewはそのデータを持つアダプタ。
のデータ、TabLayoutのタブを含む)をインスタンス化し、attachメソッドを呼び出します。ただし、タブの
のカウントは、渡されたインデックスの数より少なくなってはいけません。

```kotlin
mediator.attach();
```
タブを押したときに RecycerView がスムーズにスクロールするようにするには、smooth scroll
フラグを渡します。

```java
mediator = new TabbedListMediator(
                recyclerView,
                tabLayout,
                indices,
                false
        )
```

RecyclerViewとTabLayoutの同期を止めるには、detachメソッドを呼び出します。

```java
mediator.detach();
```

データセットが変更された場合など、Mediator をリフレッシュする場合は reAttach メソッドを呼び出します。

```java
mediator.reAttach();
```

スムーズスクロールフラグを取得するには、ゲッターのisSmoothScroll()を呼び出します。

```java
mediator.isSmoothScroll();
```

## Contributing ##
このライブラリは、他の開発者のアプリ開発を支援するために作られています。このライブラリをより有用なものにするために、アイデアを提案したり、問題やPRを作成したりして、自由に協力してください。

# ライセンス

Copyright (C) 2021 Ahmad Hamwi

This software includes the work that is distributed in the [Apache License 2.0.](https://www.apache.org/licenses/LICENSE-2.0.txt)

このソフトウェアは、 [Apache 2.0ライセンス](https://www.apache.org/licenses/LICENSE-2.0.txt) で配布されている製作物が含まれています。
