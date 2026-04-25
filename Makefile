# Définition des variables
JAVAC = javac
JAVA = java
SRC = src
OUT = classes
JUNIT = junit-console.jar
TESTS = tests
DOC_DIR = docs
JAVAFX = /usr/share/openjfx/lib
JAVAFX_MODS = javafx.controls,javafx.fxml

# Recherche des fichiers Java
SRC_FILES = $(shell find $(SRC) -name "*.java")
TEST_FILES = $(shell find $(TESTS) -name "*.java")

# Cible par défaut
all: classes

# Lancement de Livrable4a
run4a: classes
	$(JAVA) -classpath $(OUT) bloons.main.Livrable4a $(ARG1) $(ARG2) $(ARG3)

# Lancement de Livrable3b
run4b: classes
	$(JAVA) -classpath $(OUT) bloons.main.Livrable4b $(ARG1) $(ARG2) $(ARG3)

# Lancement de Livrable5
run5: classes
	$(JAVA) -classpath $(OUT) bloons.main.Livrable5 $(ARG1) $(ARG2) $(ARG3)
	
# Compilation des classes
classes:
	@echo "Compilation des fichiers source..."
	@mkdir -p $(OUT)
	$(JAVAC) -sourcepath $(SRC) -d $(OUT) $(SRC_FILES)
	@echo "Compilation terminée."

# Compilation avec JavaFX
classes-gui: classes
	@echo "Compilation avec JavaFX..."
	$(JAVAC) --module-path $(JAVAFX) --add-modules $(JAVAFX_MODS) -classpath $(OUT) -sourcepath $(SRC) -d $(OUT) $(SRC_FILES)
	@echo "Compilation terminée."

# Lancement avec JavaFX
run-gui: classes-gui
	@echo "Lancement de l'interface graphique..."
	$(JAVA) --module-path $(JAVAFX) --add-modules $(JAVAFX_MODS) -classpath $(OUT) bloons.interface_g.main.GameApp

# Génération de la javadoc
docs:
	@echo "Génération de la javadoc..."
	@mkdir -p $(DOC_DIR)
	javadoc -sourcepath $(SRC) -subpackages bloons -d $(DOC_DIR)
	@echo "Javadoc générée."

# Création des jars
jar: classes
	@echo "Création des jars..."
	jar cvfm towerdefense-a-interactive.jar manifest-interactive-a -C $(OUT) .
	jar cvfm towerdefense-b-interactive.jar manifest-interactive-b -C $(OUT) .
	jar cvfm towerdefense-interactive.jar manifest-interactive -C $(OUT) .
	@echo "Jars créés."

# Compilation des tests
tests: classes
	@echo "Compilation des tests..."
	$(JAVAC) -classpath $(JUNIT):$(OUT) -d $(OUT) $(TEST_FILES)
	@echo "Tests compilés."

# Lancement des tests
runtests: tests
	@echo "Exécution des tests..."
	-java -jar junit-console.jar -classpath classes --select-class=bloons.PlayerTest
	-java -jar junit-console.jar -classpath classes --select-class=bloons.balloon.BalloonTest
	
	-java -jar junit-console.jar -classpath classes --select-class=bloons.board.RandomBoardTest
	-java -jar junit-console.jar -classpath classes --select-class=bloons.tower.TowerTest
	-java -jar junit-console.jar -classpath classes --select-class=bloons.CellTest
	-java -jar junit-console.jar -classpath classes --select-class=bloons.PositionTest
	-java -jar junit-console.jar -classpath classes --select-class=bloons.board.ClassicalBoardTest
	$(JAVA) -jar $(JUNIT) -classpath $(OUT) --select-package=bloons
	@echo "Tests terminés."

# Nettoyage
clean:
	@echo "Suppression des fichiers compilés..."
	rm -rf $(OUT)
	@echo "Nettoyage terminé."

clean-docs:
	rm -rf $(DOC_DIR)

clean-all: clean clean-docs