job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/viniciors12/nodejsapp.git', 'master') { node ->
            node / gitConfigName('viniciors12')
            node / gitConfigEmail('viniciorodriguez97@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
}
