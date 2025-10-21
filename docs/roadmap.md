# Roadmap

## Project: MealPlannerCLI

### Vision
A tiny, fast CLI that lets me save structured recipes, plan a week of meals with smart suggestions, and spit out a clean shopping list — all local, no drama.

### Non‑Goals (for now)
- Nutrition math, unit conversions
- Mobile/GUI/DB
- Online accounts/sync

---

## Releases

### v0.1 — MVP (CLI, local JSON)
**Outcomes**
- Can add/list recipes
- Can plan a week and get suggestions
- Can generate a shopping list (Markdown)

**Scope**
- Recipe CRUD (JSON round‑trip tested)
- Planning: create plan per ISO week; set/lock slots; suggest by preferences
- Shopping list: aggregate ingredients; naive merge by same name+unit

**Acceptance Criteria**
- `recipes add/list` works and persists files
- `plan new/suggest/set` works; suggestions sorted by `lastCooked` (null first, oldest first)
- `shop build` generates expected Markdown

### v0.2 — Quality of Life
- CSV export for shopping list
- Better error messages/validation
- Config for data directory
- Basic CI (build + tests)

### v0.3 — Developer Ergonomics
- Code structure cleanup; package split (model, storage, cli, service)
- Unit tests for PlannerService/ShoppingList
- Test coverage baseline documented

### v1.0 — Polished CLI
- Packaging via jlink/jpackage (single platform ok)
- Version command, help polish
- README + examples finalized

---

## Milestones & Sequencing

**M1: Recipes (v0.1 part 1)**
- Model: Ingredient, Recipe
- Storage: JSON load/save (Jackson), file layout
- CLI: `recipes add`, `recipes list`
- Tests: JSON round‑trip, basic validation

**M2: Planning (v0.1 part 2)**
- Model: MealSlot, MealPlan
- Service: PlannerService.suggest(preferences)
- CLI: `plan new`, `plan suggest`, `plan set`, `plan cook`
- Tests: suggestion ordering, locking respected

**M3: Shopping (v0.1 part 3)**
- Model: ShoppingList aggregator
- CLI: `shop build --out`
- Tests: aggregation same name+unit

**M4: QoL (v0.2)**
- CSV export
- Config (env var or flag)
- Friendly errors

**M5: DevX (v0.3)**
- Refactor packages, add tests
- CI pipeline

**M6: Release (v1.0)**
- Packaging, help polish, docs sweep

---

## Risks & Mitigations
- **Scope creep** → Keep Icebox in backlog; protect MVP.
- **Time fragmentation** → Maintain `NEXT.md` (3 next actions) and `DEVLOG.md` (breadcrumb after each session).
- **Data consistency** → Single writer pattern: CLI commands only modify files via Storage layer; tests for round‑trip.

---

## Metrics of “Done”
- v0.1: All acceptance criteria pass; demo with 3 recipes, 1 planned week, 1 generated list.
- v1.0: `./bin/mealplanner --help` works on a clean machine; README reproducible. 
