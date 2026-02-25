# Définition des variables
JAVAC = javac
JAVA = java
SRC = src
OUT = classes
JUNIT = junit-console.jar
TESTS = tests
DOC_DIR = docs

# Recherche des fichiers Java
SRC_FILES = $(shell find $(SRC) -name "*.java")
TEST_FILES = $(shell find $(TESTS) -name "*.java")

# Cible par défaut
all: classes

# Compilation des classes
classes:
	@echo "Compilation des fichiers source..."
	@mkdir -p $(OUT)
	$(JAVAC) -sourcepath $(SRC) -d $(OUT) $(SRC_FILES)
	@echo "Compilation terminée."

# Génération de la javadoc
docs:
	@echo "Génération de la javadoc..."
	@mkdir -p $(DOC_DIR)
	javadoc -sourcepath $(SRC) -subpackages bloons -d $(DOC_DIR)
	@echo "Javadoc générée."

# Création des jars
jar: classes
	@echo "Création des jars..."
	jar cvfm livrable3a.jar manifest-3a -C $(OUT) .
	jar cvfm livrable3b.jar manifest-3b -C $(OUT) .
	@echo "Jars créés."

# Compilation des tests
tests: classes
	@echo "Compilation des tests..."
	$(JAVAC) -classpath $(JUNIT):$(OUT) -d $(OUT) $(TEST_FILES)
	@echo "Tests compilés."

# Lancement des tests
runtests: tests
	@echo "Exécution des tests..."
	$(JAVA) -jar $(JUNIT) -classpath $(OUT) --scan-classpath
	@echo "Tests terminés."

# Nettoyage
clean:
	@echo "Suppression des fichiers compilés..."
	rm -rf $(OUT)
	@echo "Nettoyage terminé."

clean-docs:
	rm -rf $(DOC_DIR)

clean-all: clean clean-docs