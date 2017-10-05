# Jehan Poublan and Jonathan Fievet

## Test Unitaire pour Java avec JUnit

>Q.1a Tester les constructeurs 1 et 2 (dans une classe de test TestMyPoint). Pour cela,
utiliser la Javadoc pour comprendre le comportement attendu des constructeurs. Utilisez des assertions
pour vérifier les valeurs.

Création des méthodes `testConstructor1()` et `testConstructor2()` dans la classe MyPointUnitTest.

>Q.1b Le test de ces constructeurs utilisent les opérations getX et getY. Ne trouvez-vous pas cela
étrange qu’un test utilise d’autres opérations ? Que faire ?

Les attributs `x` et `y` de la classe MyPointUnitTest sont privés, il est donc normal d'utiliser des
accesseurs pour accèder aux valeurs.
Il est nécessaire de les tester au préalable pour être certains qu'ils fonctionnent corectement
et qu'en cas de problème lors du test, l'anomalie ne vient pas de ces méthodes.

>Q.1c Testez les accesseurs en lecture et écriture (les opérations get et set). Tout d’abord, testez
getX et setX ensemble (car elles sont liées, idem pour y). Ensuite créez d’autres tests pour tester
les opérations set avec la valeur Double.NaN (cf. la javadoc de ces opérations).

Création des méthodes `testGetAndSetXNumber()`, `testGetAndSetXNaN()`, `testGetAndSetYNumber()` et
`testGetAndSetYNaN()` dans la classe MyPointUnitTest.


>Q.1d Testez le constructeur 3 et l’opération scale. Plusieurs tests (i.e. plusieurs opérations)
seront nécessaires pour le constructeur 3. Vous pouvez constater que la plupart des tests nécessitent
la création d’un point au début des opérations de test.

Création des méthodes `testConstructor3NotNull()`, `testConstructor3Null()` et `testConstructor3NaN()` pour
le constructeur 3 ainsi que `testScaleNumber()`, `testScaleNaN()` et `testScaleZero()` dans la classe
MyPointUnitTest.

Les tests necessite des instanciations qui se repetent. Nous avons donc implémenter les setUp() pour
éviter les redondances.


>Q.1e Définissez et utilisez l’opération @Before setUp() et tout ce qui est également nécessaire pour
déléguer cette création à l’opération setUp.

Création de 3 attributs `myPointZero`, `myPointNumbers` et `myPointNaN` dans la classe MyPointUnitTest.

>Q.1f Testez l’opération horizontalSymmetry. Là encore, plusieurs tests (i.e. plusieurs opérations) seront
nécessaires. Vous remarquerez que cette opération peut lever une exception. Utilisez le paramètre
expected de l’annotation Test pour vérifier que cette exception est bien levée en temps voulu.

Création des méthodes `testHorizontalSymmetryPositiveOrigin()`, `testHorizontalSymmetryNegativeOrigin()`,
`testHorizontalSymmetryZeroOrigin()` et `testHorizontalSymmetryNullOrigin()` dans la classe
MyPointUnitTest.


## Couverture de code

> Q.2a Utilisez l’outil de couverture de code fourni dans Eclipse (ou autre IDE) pour identifier les chemins
dans le code non couvert par vos tests. Rajoutez quelques tests si besoins (n’y passez pas trop de temps).

L'outil de couverture de test fournit par IntelliJ IDEA nous donne le pourcentage des méthodes et
classes couvertes par les tests. 

Voici une capture d'écran des résultats :
![couvertureavant.bitmap](https://i.imgur.com/9GLAn6K.jpg)

Voici une capture d'écran des résultats après l'implémentation de tous les tests :
![couvertureapres.png](https://i.imgur.com/0994ewf.jpg)

On observe que toutes les méthodes ont été couvertes.
![achievement.jpg](https://i.imgur.com/dxr9dhK.png)

Création des méthodes `testComputeAngle()`, `testRotatePoint()`, `testCentralSymmetryNull()`,
`testGetMiddlePoint()` et `testTranslate()` dans la classe MyPointUnitTest.

> Q.2b Est-ce que votre code est sûr lorsque toutes les instructions sont couvertes par au moins un test ?

Absolument pas. Un test par méthode est le minimum requis, mais bien souvent il ne suffit pas. Il faut
couvrir tout les chemins possible pour avoir une couverture de test optimale.

> Q.2c Ajoutez le test unitaire suivant et exécutez-le. S’il passe, bien joué. Dans tout les cas cela peut
certainement vous aidez à répondre à la question précédente.

    @Test public void testCentralSymmetryNULL ( ) {
        new MyPoint ( 1 0 , 2 0 ) . centralSymmetry ( null ) ;
    }

Test unitaire implémenté à la question Q.2a.

## Test d'intégration pour Java avec EasyMock ou Mockito

Cet exercice est une brève introduction au principe du mock.

L’opération setPoint(Random r1, Random r2) définit les coordonnées d’un point de manière aléatoire
(x avec r1, et y avec r2).

> Q.3a Expliquez en quoi il est impossible de tester en l’état cette opération.
    >> On veut donc utiliser le principe du Mock pour tester cette opération.

La méthode `Random.nextInt()` génére un nombre aléatoire different à chaque appel, il est donc
impossible de tester la valeur puisqu'elle est sans cesse differente. Grâce au Mock, nous allons
pouvoir contrôler le resultat renvoyé par notre Mock Random et ainsi pouvoir tester sa valeur.

> Q.3b Utilisez Easymock ou Mockito pour tester cette opération.

Avec JUnit 5, `@RunWith` n'existe plus. Il faut utiliser `@ExtendWith(MockitoExtension.class)`.
Création de la méthode `testSetPointRandomMock()` dans la classe MyPointIntegrationTest.

> Q.3c Supposons que nous ne disposons pas d’une implémentation de ITranslation pour tester cette opération,
utilisez Mockito ou Easymock et tester finalement cette opération.

Création de la méthode `testTranslateMock()` dans la classe MyPointIntegrationTest.
