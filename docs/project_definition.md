# Project One-Pager (Small)

## Project Name
Meal Planner CLI

## Goal / Problem Statement
A small Java CLI app that manages recipes, weekly meal planning, and generates shopping lists.  
Personal need: plan meals, track cooking frequency, and quickly generate shopping lists.

## Tech Stack
- Java 21+
- CLI: picocli
- JSON: Jackson
- Build: Gradle
- Test: JUnit

## Core Features (MVP)
1. **Recipe Management**
   - Add, list, and store recipes as JSON files.
   - Each recipe has name, ingredients, cooking time, speed category, batch-friendly flag, last cooked date, and times cooked counter.

2. **Meal Planning**
   - Create a plan per week (ISO week format).
   - Assign recipes to slots with preferences (speed, batch).
   - Suggest recipes sorted by last cooked (oldest first).

3. **Shopping List**
   - Generate a shopping list from planned recipes.
   - Output in Markdown.

## Out of Scope (Future)
- Default menus (e.g. breakfast staples)
- Pantry checklist (always-have items)
- Telegram integration

## Data Storage
- Local JSON files in `data/recipes/`, `data/plans/`, `data/shopping/`.

## Milestones
- **M1:** CRUD recipes + JSON round-trip tests.
- **M2:** Weekly planning & suggestion logic.
- **M3:** Shopping list generation.

## Testing
- Round-trip JSON serialization
- Suggestion order respects `lastCooked`
- Locking slots respected
- Ingredient aggregation correct

## Deliverables
- Gradle Java project
- CLI app via picocli
- README with schema + usage examples
