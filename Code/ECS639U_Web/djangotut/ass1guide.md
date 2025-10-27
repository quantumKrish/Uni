
## File Structure
mysite/
│
├── manage.py # Main control file
├── mysite/
│     ├── settings.py # Project settings (apps, database)
│     ├── urls.py # Main URL router
│
└── polls/
├── models.py # Database models
├── views.py # Business logic (what happens per request)
├── urls.py # Maps local routes to views
├── templates/polls/ # HTML templates
└── admin.py # Register models for admin site


## Common Commands

| Command                            | What It Does                                  |
|------------------------------------|-----------------------------------------------|
| `python manage.py runserver`       | Start the development server                  |
| `python manage.py makemigrations`  | Create migration files for new/updated models |
| `python manage.py migrate`         | Apply migrations to the database              |
| `python manage.py createsuperuser` | Create an admin login account                 |
| `python manage.py shell`           | Open Django’s interactive Python shell        |


## Request Flow (How Django Handles a Request)

1. User visits a URL like `/polls/`
2. Django checks `mysite/urls.py` → includes `polls/urls.py`
3. `polls/urls.py` maps the path to a function in `views.py`
4. The **view** fetches data from the **model**
5. The **view** renders a **template** with that data
6. Django sends the finished HTML back to the browser



## Key Django Components

| File           | Role                                      | Example                         |
|----------------|-------------------------------------------|---------------------------------|
| **models.py**n | Defines data structures (database tables) | `Question`, `Choice`            |
| **views.py**   | Handles logic and returns responses       | `index()`, `detail()`           |
| **urls.py**    | Connects URLs to views                    | `path("", views.index)`         |
| **templates/** | Stores HTML files shown to the user       | `index.html`, `detail.html`     |
| **admin.py**   | Registers models for admin panel          | `admin.site.register(Question)` |
| **manage.py**  | Django’s main control tool                | Runserver, migrations, etc.     |


## Viva Practice Tasks

| Task                          | What To Do                                                                                           |
|-------------------------------|------------------------------------------------------------------------------------------------------|
| **Change a class name**       | Update the name in `models.py`, run `makemigrations`, `migrate`. Fix imports and admin registration. |
| **Rename a class attribute**  | Change the field name in `models.py`, run migrations, update views/templates using it.               |
| **Create & apply migrations** | `python manage.py makemigrations` → `python manage.py migrate`.                                      |
| **Run server**                | `python manage.py runserver`.                                                                        |
| **Change URL path**           | Edit `polls/urls.py`, e.g., change `"vote/"` → `"voting/"`.                                          |     
| **Rename a view function**    | Change the function name and update it in `urls.py`.                                                 |
| **Rename a template**         | Change the file name and update the template path in the `render()` call.                            |


## Quick Tips

- Always restart the dev server after major edits.
- If you change models → always run migrations.
- Use `Ctrl + C` to stop the server in the terminal.
- Admin site is at: `http://127.0.0.1:8000/admin/`
