pipelineJob('DeclarativePipeline_converted') {

  description('')

  displayName('DeclarativePipeline_converted')

  keepDependencies(false)

  quietPeriod(0)

  checkoutRetryCount(0)

  disabled(false)

  concurrentBuild(false)

  configure { flowdefinition ->

    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction'(plugin:'pipeline-model-definition@1.5.1')

    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction'(plugin:'pipeline-model-definition@1.5.1') {

      'jobProperties'()

      'triggers'()

      'parameters'()

      'options'()

    }

    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition',plugin:'workflow-cps@2.78') {

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
