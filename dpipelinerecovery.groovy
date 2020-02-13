pipelineJob('DeclarativePipeline_converted') {

  description('')

  displayName('DeclarativePipeline_converted')

  keepDependencies(false)

  configure { flowdefinition ->

    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction'(plugin:'pipeline-model-definition')

    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction'(plugin:'pipeline-model-definition') {

      'jobProperties'()

      'triggers'()

      'parameters'()

      'options'()

    }

    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition',plugin:'workflow-cps') {

      'script'('''      pipeline {
                agent any
                stages {
                    stage(\'env\') {
                        steps {
                            sh \'printenv\'
                        }
                    }

                    stage(\'Test\') {
                          environment{
                                  test_number = \'513\'
                          }

                        steps {
                            echo "build is ${env.BUILD_ID}"
                            echo "test number is ${env.test_number}"
                        }
                    }

                }
            }''')

      'sandbox'(true)

    }

  }

}
