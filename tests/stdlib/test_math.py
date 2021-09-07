from unittest import expectedFailure

from .. utils import TranspileTestCase, BuiltinFunctionTestCase, BuiltinTwoargFunctionTestCase

class MathTests(TranspileTestCase):
    def test_trunc1(self):
        self.assertCodeExecution("""
            from math import trunc
            x = 3.1
            y = 0.9
            z = -1.1
            w = -0.9999999999999999999999999999999999
            print(trunc(x))
            print(trunc(y))
            print(trunc(z))
            print(trunc(w))
        """)

    # @expectedFailure
    # def test_trunc2(self):
    #     self.assertCodeExecution("""
    #         import math
    #         print(math.trunc('not a number'))
    #     """)

    # @expectedFailure
    # def test_trunc3(self):
    #     self.assertCodeExecution("""
    #         import math
    #         print(math.trunc(['not', 'a', 'number']))
    #     """)
