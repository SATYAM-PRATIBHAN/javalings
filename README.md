# Javalings 🚧 Work in Progress

## Getting Started

### Installation
You can install the Javalings CLI globally using our install script. This requires Java and Maven to be installed on your system.

```bash
# 1. Run the installation script
curl -sL https://raw.githubusercontent.com/SATYAM-PRATIBHAN/javalings/main/install.sh | bash

# 2. Add the bin folder to your PATH (if not already done)
# For bash:
echo 'export PATH="$HOME/.javalings/bin:$PATH"' >> ~/.bashrc
source ~/.bashrc
# For zsh:
echo 'export PATH="$HOME/.javalings/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc

# 3. Initialize the javalings project in your desired directory
javalings init

# 4. Move into the directory
cd javalings

# 5. Start learning!
javalings
```

In the meantime, enjoy watching **Conway's Game of Life**. It's a mesmerizing "zero-player game" where cells evolve automatically based on a set of simple rules:

<div align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/e/e5/Gospers_glider_gun.gif" alt="Conway's Game of Life - Gosper Glider Gun" width="500" style="border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.2);" />
  <br>
  <i>(A Gosper Glider Gun infinitely creating new gliders)</i>
</div>