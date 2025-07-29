// package com.example.bot;

// import dev.langchain4j.service.UserMessage;

// public interface MyAgent {
//     @UserMessage
//     String chat(String userInput);
// }
package com.example.bot;

import dev.langchain4j.service.UserMessage;

public interface MyAgent {

    String chat(@UserMessage String message);
}
