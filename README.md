# MS Teams Incoming Webhook

**MS Teams Incoming Webhook** is used to provide MS Teams message posting to Java applications.  

Features
--------
The guide at [Card Reference] provides an introduction to messaging on various Office applications, which includes MS Teams.  The bits and pieces relevant for Teams were codified here, and a sample client was provided for convenience.  


Developer
---------

See the API test cases for more elaborate examples of building a Card for delivery.  Additionally, consult the [Card Reference] for examples of using sections, actions, and other features.  Finally, the [Card Playground] is a great place to build your own cards.

```java
Card card = new Card("Card \"Test card\"", "0078D7", "Card created: \"Name of card\"");

List<Section> sections = new ArrayList<Section>();
Section sectionOne = new Section(
        "David Claux",
        "9/13/2016, 3:34pm",
        "https://connectorsdemo.azurewebsites.net/images/MSC12_Oscar_002.jpg");
sectionOne.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
card.setSections(sections);
```

The provided TeamsClient simply needs a URL and Card to send.  This is a bare-bones implementation using the Jersey client.  
  
```java
new TeamsClient(url).sendMessage(card);
```

Production applications may require more features, such as logging, retries, exception handling, and asynchronous operation.  Feel free to discard this client and write your own.  Please note there is a dependency on the Jersey client, which may need to be ignored in your own build file if you choose to go this route.

<!---
Link References
-->
[Card Reference]:https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference
[Card Playground]:https://messagecardplayground.azurewebsites.net/