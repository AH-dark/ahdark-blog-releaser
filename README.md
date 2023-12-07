# AHdark Blog Releaser

## Introduction

This project is a Kotlin-based HTTP server designed to handle GitHub Webhooks. It automatically forwards push
notifications from the `main` branch of a GitHub repository to a specified Telegram chat, facilitating real-time
updates.

## Features

- Receives GitHub Webhook payloads.
- Filters and processes push events to the `main` branch.
- Sends notifications to a designated Telegram chat.

## Getting Started

### Prerequisites

- Kotlin
- Git

### Installation

1. Clone the repository:
    ```shell
    git clone git@github.com:AH-dark/ahdark-blog-releaser.git
    ```
2. Build the project:
    ```shell
    ./gradlew build
    ```

### Configuration

1. Copy the `config.example.properties` file to `config.properties`.
2. Set your Telegram Bot token and chat ID in the `config.properties` file.

### Running the Server

To start the server, run:

```shell
./gradlew run
```

## Project Structure

- `src/main/kotlin/com/ahdark/code`: Contains the main application and various components like controllers, entities,
  services, etc.
- `src/main/resources`: Contains configuration files like `config.properties` and `logback.xml`.
- `src/test/kotlin/com/ahdark/code`: Contains test cases for the application.

## Contributing

Contributions are welcome. Feel free to fork the project and submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
