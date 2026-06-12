# ☕ Javalings

Welcome to **Javalings**! This project is inspired by Rustlings and is designed to help you learn Java by fixing broken code. Whether you're a complete beginner looking to understand syntax, or someone returning to Java looking to brush up on modern features, Javalings guides you step-by-step through a curated curriculum.

---

## 🎯 What is Javalings?

Reading a book or watching a tutorial is great, but nothing beats writing code. **Javalings** provides a series of small exercises that are designed to fail—either they won't compile, or their unit tests will fail. Your job is to make them work!

The built-in CLI will automatically watch your files, compile them, and run tests in the background. It provides instant feedback so you can rapidly iterate and learn.

## 🚀 Getting Started

### Prerequisites
- **Java 21** (or newer)
- **Maven** (required for the installation script)
- **Git** (to clone the curriculum)

### Installation
You can easily install the Javalings CLI globally using our install script. 

```bash
# 1. Run the installation script
curl -sL https://raw.githubusercontent.com/SATYAM-PRATIBHAN/javalings/main/install.sh | bash

# 2. Add the bin folder to your PATH (if not already done)
# For bash:
echo 'export PATH="$HOME/.javalings/bin:$PATH"' >> ~/.bashrc
source ~/.bashrc
# For zsh (Mac defaults):
echo 'export PATH="$HOME/.javalings/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc

# 3. Initialize the javalings project in your desired directory
javalings init

# 4. Move into the directory
cd javalings

# 5. Start learning!
javalings
```

---

## 🛠️ Doing Exercises

Once you run `javalings` inside the initialized folder, the interactive watcher will start. It looks at the first exercise in the curriculum and tries to compile and test it.

1. Open the `javalings` folder in your favorite text editor or IDE.
2. Read the error message in the CLI to figure out what's wrong.
3. Open the corresponding exercise file (e.g., `exercises/001-variables/Variables1.java`).
4. Fix the code!
5. Save the file. The `javalings` CLI will automatically recompile and test it.
6. Once it passes, remove the `// I AM NOT DONE` comment from the file to proceed to the next exercise.

### Using Hints
If you ever get stuck, you can type `h` in the interactive CLI or run `javalings hint` in a separate terminal window to get a helpful nudge.

---

## 💻 CLI Commands

When you aren't using the default interactive `watch` mode, you can use these commands manually:

- `javalings watch` - (Default) Watches files and auto-runs tests on save.
- `javalings run` - Compiles and tests the current pending exercise once.
- `javalings list` - Shows the full curriculum and your current progress.
- `javalings hint` - Shows a hint for the current pending exercise.
- `javalings show` - Shows detailed information about the current exercise.

---

## 📚 Curriculum 

The curriculum consists of 30 modules, carefully ordered to build your knowledge incrementally:

1. **Basics:** Variables, Datatypes, Operators, Type Casting
2. **Control Flow:** Conditionals, Loops
3. **Data Structures:** Arrays, Strings
4. **Methods & OOP:** Methods, Overloading, Classes, Objects, Constructors
5. **Advanced OOP:** Encapsulation, Access Modifiers, Static, Final, Inheritance, Polymorphism, Abstract Classes, Interfaces
6. **Robustness:** Exceptions, Generics
7. **Modern Java:** Collections, Lambdas, Streams, Optional, Enums, Packages, File Handling

---

## 🤝 Contributing

Want to add new exercises or fix bugs? Contributions are welcome! 

1. **Fork & Clone** the repository.
2. **Add your exercise** to the `exercises/` directory. 
3. **Add the JUnit test** to the `tests/` directory.
4. **Register the exercise** in `info.json` at the root of the project. Include the slug, title, difficulty, and hints.
5. **Test locally** by running `./install.sh` from the repository root to build your local changes.
6. **Submit a PR!** 