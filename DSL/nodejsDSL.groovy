job('SCM Jenkins app') {
    description('Node JS Jenkins SCM')
    scm {
        git('https://github.com/viniciors12/nodejsapp.git', 'master') { node ->
            node / gitConfigName('viniciors12')
            node / gitConfigEmail('viniciorodriguez97@gmail.com')
        }
    }
    parameters {
   		stringParam('nombre', defaultValue = 'Vini', description = 'Parametro de cadena para el Job Booleano')
        choiceParam('planeta', ['Mercurio', 'Pluto', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
        booleanParam('agente', false)
    }
    triggers {
        scm('H/7 * * * *')
        githubPush()
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("echo Hello world!!!")
    }
}
