
# Tick_Tack_Toe using Facade Design Pattern

A console-based Tic-Tac-Toe game implemented using the GoF Facade Pattern, designed with clean architecture, modularity, and scalability in mind.

## Overview
- TicTacToeFacade acts as the main orchestration layer (entry point to game logic)
- Menu handles mode selection and user interaction
- Facade exposes simple APIs:
  - startGame() → internally manages:
     - Human vs Human
     - Human vs Computer
- Board, Player, and validation classes manage core gameplay
- Input handling and validation are decoupled for flexibility and reuse

## Package Breakdown

| Package | Classes | Role |
|--------|--------|------|
| `model` | `Board`, `GameState` | Maintains board state and game result |
| `model.facade` | `TicTacToeFacade`, `Menu` | Entry point + user interaction |
| `model.player` | `Player`, `HumanPlayer`, `ComputerPlayer` | Player abstraction & behaviors |
| `model.io` | `InputReader` | Handles user input safely |
| `model.validation` | `InputValidator`, `GameValidator`, `CellMapper` | Validation & mapping logic |
| `model.exception` | `InvalidInputException`, `InvalidMoveException` | Custom domain exceptions |
| `test` | `GameStarter` | Application launcher |

## Design
| Pattern | Where Used | Description |
|--------|--------|------|
| `Facade` | `TicTacToeFacade` | Provides a simple interface to complex subsystems |
| `Strategy (Behavioral)` | `Player → HumanPlayer`, `ComputerPlayer` | Different move strategies |
| `Polymorphism` | `Player hierarchy` | Game logic works on abstraction |
| `Separation of Concerns` | `validation`, `io`, `exception` | Clean architecture |
| `Template-like Flow` | `Game loop in facade` | Fixed flow, variable behavior |



## Package Structure

<img width="811" height="747" alt="image" src="https://github.com/user-attachments/assets/3407caf2-8328-48b4-9dc0-ab1d91741a83" />

## Program Flow
<img width="550" height="350" alt="image" src="https://github.com/user-attachments/assets/581e0adb-768a-4915-a5cd-e51dacb77921" />

## UML Arrow Notation Guide

| Symbol | Type | Description |
|--------|------|------------|
| `──▶` | Association | Field/reference relationship |
| `──▷` | Inheritance | Class extends another class |
| `╌╌▷` | Implementation | Class implements interface |
| `╌╌▶` | Dependency | Temporary usage (method-level) |

## UML Class Digram
<img width="2498" height="1560" alt="tick_tack_toe_facade" src="https://github.com/user-attachments/assets/e9f28595-a21a-43d2-aeff-93cec596d3c5" />


