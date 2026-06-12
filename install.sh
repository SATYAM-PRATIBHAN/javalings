#!/usr/bin/env bash
set -e

# Javalings Installer Script

echo "========================================="
echo "📦 Installing Javalings CLI globally..."
echo "========================================="

# Check if we are running this inside the repository
if [ -f "pom.xml" ] && grep -q "<artifactId>javalings</artifactId>" pom.xml; then
    echo "Local repository detected. Building JAR..."
    mvn clean compile assembly:single -q
    JAR_PATH="target/javalings-0.1.0-jar-with-dependencies.jar"
else
    echo "Downloading source..."
    TEMP_DIR=$(mktemp -d)
    cd "$TEMP_DIR"
    git clone -q https://github.com/SATYAM-PRATIBHAN/javalings.git .
    echo "Building JAR..."
    mvn clean compile assembly:single -q
    JAR_PATH="target/javalings-0.1.0-jar-with-dependencies.jar"
fi

# Ensure bin directory exists
mkdir -p ~/.javalings/bin

echo "Copying to ~/.javalings/javalings.jar..."
cp $JAR_PATH ~/.javalings/javalings.jar

echo "Detecting Java runtime used by Maven..."
MAVEN_JAVA_HOME=$(mvn -v | grep 'runtime:' | awk '{print $NF}')
JAVA_EXEC="java"

if [ -n "$MAVEN_JAVA_HOME" ] && [ -x "$MAVEN_JAVA_HOME/bin/java" ]; then
    JAVA_EXEC="$MAVEN_JAVA_HOME/bin/java"
    echo "Found Java at $JAVA_EXEC"
else
    echo "Using default 'java' command"
fi

echo "Creating 'javalings' wrapper script..."
cat << EOF > ~/.javalings/bin/javalings
#!/usr/bin/env bash
"$JAVA_EXEC" -jar ~/.javalings/javalings.jar "\$@"
EOF

chmod +x ~/.javalings/bin/javalings

# Clean up temp dir if we used one
if [ -n "$TEMP_DIR" ]; then
    cd ~
    rm -rf "$TEMP_DIR"
fi

echo "========================================="
echo "✅ Javalings successfully installed!"
echo "========================================="
echo ""
echo "⚠️  Important: You must add ~/.javalings/bin to your PATH to use the 'javalings' command everywhere."
echo ""
echo "For bash users (e.g. Linux/Mac defaults):"
echo "  echo 'export PATH=\"\$HOME/.javalings/bin:\$PATH\"' >> ~/.bashrc"
echo "  source ~/.bashrc"
echo ""
echo "For zsh users (Mac defaults):"
echo "  echo 'export PATH=\"\$HOME/.javalings/bin:\$PATH\"' >> ~/.zshrc"
echo "  source ~/.zshrc"
echo ""
echo "Then, you can initialize the exercises in any folder:"
echo "  javalings init"
echo "  cd javalings"
echo "  javalings"
echo ""
