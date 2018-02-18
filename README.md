# MS Teams Incoming Webhook

** MS Teams Incoming Webhook ** is used to provide MS Teams message posting to Java applications.  

Features
--------
The guide at [Card Reference] provides an introduction to messaging on various Office applications, which includes MS Teams.  The bits and pieces relevant for Teams were codified here, and a sample client was provided for convenience.  

<!---
Link References
-->
[Card Reference]:https://docs.microsoft.com/en-us/outlook/actionable-messages/card-reference


Developer
---------

See the API test cases for more elaborate examples of building a Card for delivery.  Additionally, consult the [Card Reference] for examples of using sections, actions, and other features.

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

The provided TeamsClient simply needs a URL and message to send. 
```java
new TeamsClient(url).sendMessage(card);
```