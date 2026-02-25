# Définition des variables
JAVAC = javac
JAVA = java
SRC = src
OUT = classes
JUNIT = junit-console.jar
TESTS = tests

# Recherche des fichiers Java
SRC_FILES = $(shell find $(SRC) -name "*.java")
TEST_FILES = $(shell find $(TESTS) -name "*.java")

# Cible par défaut
all: build run

# Compilation du projet
classes:
	@echo "Compilation des fichiers source..."
	@mkdir -p $(OUT)
	$(JAVAC) -sourcepath $(SRC) -d $(OUT) $(SRC_FILES)
	@echo "Compilation terminée."

# Exécution du jeu
run:
	@echo "Exécution du jeu..."
	$(JAVA) -classpath $(OUT) bloons..main.Livrable2a

# Compilation et exécution des tests
runtests: build
	@echo "Compilation des tests..."
	$(JAVAC) -classpath $(JUNIT):$(OUT) -d $(OUT) $(TEST_FILES)
	@echo "Exécution des tests..."
	$(JAVA) -jar $(JUNIT) -classpath $(OUT) --scan-classpath
	@echo "Tests terminés."

# Nettoyage des fichiers compilés
clean:
	@echo "Suppression des fichiers compilés..."
	rm -rf $(OUT)
	@echo "Nettoyage terminé."

# Dossier où sera générée la documentation
DOC_DIR = docs

# Génération de la documentation avec Javadoc
docs:
	javadoc -sourcepath $(SRC) -subpackages bloons -d $(DOC_DIR)


# Nettoyer la documentation
clean-docs:
	rm -rf $(DOC_DIR)
jar :

	jar cvfm Livrable3a.jar manifest -C classes .
	jar cvfm Livrable3b.jar manifest -C classes .

# Nettoyer tout (compilation + doc)
clean-all: clean clean-docs