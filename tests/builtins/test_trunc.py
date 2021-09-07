from .. utils import TranspileTestCase, BuiltinFunctionTestCase, BuiltinTwoargFunctionTestCase

class TruncTests(TranspileTestCase):
    def test_trunc1(self):
        self.assertCodeExecution("""
            x = 3
            y = 4
            z = 5
            try:
                print(pow(x, y, z))
            except TypeError as err:
                print(err)
        """)