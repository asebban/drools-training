[condition][]La personne a un âge supérieur à {age} et un revenu supérieur à {income} et est employée = person : Person(age > {age}, income > {income}, employed)
[condition][]La personne a un âge inférieur à {age} et est non employée = person : Person(age < {age}, !employed)
[then][]Attribuer un score de {score} = person.setScore({score});
[then][]Afficher le score = System.out.println("Score de " + person.getName() + " : " + person.getScore());
