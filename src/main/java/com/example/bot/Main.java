package com.example.bot;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;

import java.util.Scanner;

public class Main {

    public interface SimpleAgent {
        String chat(String userMessage);
    }

    public static void main(String[] args) {

        SimpleAgent agent = AiServices.builder(SimpleAgent.class)
                .chatLanguageModel(OllamaChatModel.builder()
                        .baseUrl("http://localhost:11434")
                        .modelName("llama3") // or mistral, phi3, etc.
                        .build())
                .build();

        Scanner scanner = new Scanner(System.in);
        System.out.println("🧠 Simple Chat Agent with Ollama. Type your question:");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String response = agent.chat(input);
            System.out.println("🤖: " + response);
        }
    }
}


// package com.example.bot;

// // import dev.langchain4j.memory.chat.ChatMemory;
// import dev.langchain4j.memory.chat.MessageWindowChatMemory;
// import dev.langchain4j.model.ollama.OllamaChatModel;
// import dev.langchain4j.service.AiServices;

// import java.util.Scanner;

// public class Main {

//     public interface SimpleAgent {
//         String chat(String userMessage);
//     }

//     public static void main(String[] args) {

//         CalculatorTool calculatorTool = new CalculatorTool();

//         // Add chat memory with a minimum of 3 messages
//         MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(5);

//         SimpleAgent agent = AiServices.builder(SimpleAgent.class)
//                 .chatLanguageModel(OllamaChatModel.builder()
//                         .baseUrl("http://localhost:11434")
//                         .modelName("llama3")
//                         .build())
//                 .chatMemory((dev.langchain4j.memory.ChatMemory) chatMemory)              // ✅ Required for tool use
//                 .tools(calculatorTool)               // ✅ Add your custom tool
//                 .build();

//         Scanner scanner = new Scanner(System.in);
//         System.out.println("🧠 Simple Chat Agent with Ollama + Tools + Memory. Type your question:");

//         while (true) {
//             System.out.print("> ");
//             String input = scanner.nextLine();
//             String response = agent.chat(input);
//             System.out.println("🤖: " + response);
//         }
//     }
// }

