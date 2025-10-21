# Backlog

Use this as a Kanban: **Next → Doing → Review → Done**. Keep WIP low (max 2).  
Labels: `core`, `cli`, `storage`, `service`, `tests`, `docs`, `qol`, `future`.

---

## Next (Top 3 only)
- [ ] Init Gradle project with picocli, Jackson, JUnit (`core`, `docs`)
- [ ] Implement Recipe + Ingredient models; JSON round‑trip test (`core`, `tests`)
- [ ] CLI skeleton `recipes list` reading from `data/recipes` (`cli`, `storage`)

---

## v0.1 — MVP

### M1: Recipes
- [ ] Storage: ensure `data/recipes` directory exists (`storage`)
- [ ] Command: `recipes add` with `--name`, `--time`, `--speed`, `--batch`, `--ing` (multi) (`cli`)
- [ ] Validate speed enum: `fast|regular|complex` (`cli`)
- [ ] List filter flags `--speed`, `--batch` (`cli`)
- [ ] Tests: JSON round‑trip ignore mutable fields (`tests`)
- [ ] Docs: update README with examples (`docs`)

### M2: Planning
- [ ] Model: MealSlot(day, slot, locked, preferences, recipeId) (`core`)
- [ ] Model: MealPlan(week, meals) (`core`)
- [ ] Service: PlannerService.suggest(preferences) (`service`)
- [ ] Command: `plan new --week` (`cli`)
- [ ] Command: `plan suggest --week --day --slot --speed --batch --top` (`cli`)
- [ ] Command: `plan set --week --day --slot --recipe --locked` (`cli`)
- [ ] Command: `plan cook --recipe --date` updates `lastCooked` & `timesCooked` (`cli`, `storage`)
- [ ] Tests: suggestion ordering (null first, oldest first) (`tests`)
- [ ] Tests: locking respected (`tests`)

### M3: Shopping
- [ ] Model: ShoppingList aggregator (`core`, `service`)
- [ ] Command: `shop build --week --out` (`cli`)
- [ ] Aggregation: sum same-name+same-unit; list otherwise (`service`)
- [ ] Output: Markdown file with header `Shopping List — <week>` (`cli`)
- [ ] Tests: aggregation cases (`tests`)

---

## v0.2 — Quality of Life
- [ ] CSV export for shopping list (`cli`)
- [ ] Config flag `--data-dir` or env var `MEALPLANNER_HOME` (`cli`)
- [ ] Input validation + friendly error messages (`cli`)
- [ ] Command `--version` & `--help` polish (`cli`)

## v0.3 — Dev Ergonomics
- [ ] Package split: `model`, `storage`, `service`, `cli` (`core`)
- [ ] CI: build + tests (GitHub Actions) (`docs`, `tests`)
- [ ] Test coverage baseline report (`tests`)

## v1.0 — Polished
- [ ] jlink/jpackage packaging (`qol`)
- [ ] README examples verified end‑to‑end (`docs`)

---

## Icebox (Future Ideas)
- [ ] Default menus (breakfast/dinner staples) (`future`)
- [ ] Pantry checklist (`future`)
- [ ] Telegram send of selected recipe steps (`future`)
- [ ] Unit conversions (`future`)
- [ ] Import/export recipes (JSON) (`future`)

---

## Working Agreements
- Keep `NEXT.md` to 3 items max; update after every session.
- Leave a breadcrumb in `DEVLOG.md`: what changed, what’s next.
- Small commits; conventional message style:
  - `feat(recipes): add CLI to create recipe`
  - `fix(storage): normalize path for windows`
  - `test(planner): sort by lastCooked with nulls first`
