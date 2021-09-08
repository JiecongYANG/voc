import unittest

from .. utils import TranspileTestCase, BuiltinFunctionTestCase, BuiltinTwoargFunctionTestCase

class MathTests(TranspileTestCase):
    def test_fabs(self):
        self.assertCodeExecution("""
            import math
            x1 = 0.0
            x2 = 0.9
            x3 = -1.1
            x4 = -1
            x5 = 10
            x6 = 0
            print(math.fabs(x1))
            print(math.fabs(x2))
            print(math.fabs(x3))
            print(math.fabs(x4))
            print(math.fabs(x5))
            print(math.fabs(x6))
        """)

    @unittest.expectedFailure
    def test_fabs_incorrect(self):
        self.assertCodeExecution("""
            import math
            x7 = "incorrect input"
            print(math.fabs(x7))
        """)
