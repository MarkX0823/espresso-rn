/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, FlatList} from 'react-native';
import setTestID from './testUtils';

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  render() {
    return (
      <View style={styles.container}>
        <Text accessible={true} accessibilityLabel="myText1" style={styles.welcome}>Welcome to React Native!</Text>
        <Text {...{accessible: true, accessibilityLabel: "myText2"}} style={styles.instructions}>To get started, edit App.js</Text>
        <Text {...setTestID("myText3")} style={styles.instructions}>{instructions}</Text>
        <FlatList 
          {...setTestID("myList1")}
          data={[
            {key: 'a'},
            {key: 'b'},
            {key: 'c'},
            {key: 'd'},
            {key: 'e'},
            {key: 'f'},
          ]}
          renderItem={({item}) => <Text style={styles.item}>{item.key}</Text>}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
});
