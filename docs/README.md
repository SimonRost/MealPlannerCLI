# Meal Planner CLI

A small Java CLI tool to manage recipes, plan weekly meals, and generate shopping lists.

---

## Features
- Save and list recipes (JSON format)
- Plan meals per week, assign recipes to days
- Suggest meals based on preferences
- Generate aggregated shopping lists in Markdown

---

## Data Schema

### Recipe JSON (`/data/recipes/<id>.json`)
```json
{
  "id": "spaghetti-tomato-2025-09-30",
  "name": "Spaghetti mit Tomatensauce",
  "ingredients": [
    {"name": "Spaghetti", "qty": 500, "unit": "g"},
    {"name": "Tomatensauce", "qty": 1, "unit": "jar"},
    {"name": "Olivenöl", "qty": 2, "unit": "tbsp"}
  ],
  "time_minutes": 25,
  "speed": "regular",
  "batch_friendly": true,
  "last_cooked": null,
  "times_cooked": 0,
  "notes": "Salt the pasta water generously."
}
```

### Weekly Plan JSON (`/data/plans/2025-W40.json`)
```json
{
  "week": "2025-W40",
  "meals": [
    {
      "day": "Mon",
      "slot": "dinner",
      "locked": true,
      "preferences": {"speed": "fast", "batch": true},
      "recipe_id": "spaghetti-tomato-2025-09-30"
    },
    {
      "day": "Tue",
      "slot": "dinner",
      "locked": false,
      "preferences": {"speed": "regular", "batch": false},
      "recipe_id": null
    }
  ]
}
```

---

## CLI Usage (planned with picocli)

### Recipes
```bash
recipes add --name "Spaghetti mit Tomatensauce"   --time 25 --speed regular --batch true   --ing "Spaghetti:500:g" --ing "Tomatensauce:1:jar" --ing "Olivenöl:2:tbsp"

recipes list [--speed fast|regular|complex] [--batch true|false]
```

### Planning
```bash
plan new --week 2025-W40

plan suggest --week 2025-W40 --day Tue --slot dinner   --speed regular --batch false --top 5

plan set --week 2025-W40 --day Tue --slot dinner   --recipe spaghetti-tomato-2025-09-30 --locked true

plan cook --recipe spaghetti-tomato-2025-09-30 --date 2025-10-01
```

### Shopping
```bash
shop build --week 2025-W40 --out shopping-2025-W40.md
```

Example Markdown output:
```markdown
# Shopping List — 2025-W40
- Spaghetti — 500 g
- Tomatensauce — 1 jar
- Olivenöl — 2 tbsp
```

---

## Roadmap
- v0.1: Recipes CRUD, planning, shopping list
- v1.1: Default menus
- v1.2: Pantry checklist
- v1.3: Telegram integration
