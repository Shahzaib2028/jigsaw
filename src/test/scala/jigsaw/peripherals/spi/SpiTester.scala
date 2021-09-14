package jigsaw.peripherals.spi

import chisel3._
import chisel3 . util._
import caravan.bus.tilelink._
import org.scalatest._
import chisel3.experimental._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
// import org.scalatest.flatspec.AnyFlatSpec
import jigsaw.peripherals.spi._



class SpiTester extends FreeSpec with ChiselScalatestTester {

//   "Spi Master Tests" in {
//     test(new SpiMaster()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
//         c.clock.step(20)
//     }
//   }

//   "Spi Slave Tests" in {
//     test(new SpiSlave()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
//         c.clock.step(20)
//     }
//   }

  //  "Spi Wrapper Tests" in {
  //   test(new SpiWrapper()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
  //       c.io.dataRequest.bits.poke("b10111011101110111011101110111011".U)
  //       c.io.activeByteLane.poke("b11111111111111111111111111111111".U)
  //       c.io.dataRequest.valid.poke(1.B)
  //       c.io.dataResponse.ready.poke(1.B)
  //       c.clock.step(10)
  //       c.io.dataRequest.bits.poke("b11111110000000001111111111000000".U)
  //       // c.io.dataRequest.valid.poke(1.B)
  //       // c.io.dataResponse.ready.poke(1.B)
  //       var count = 1
  //       while(count != 2000) {
  //           val mosi = c.io.mosi.peek()
  //           c.io.miso.poke(mosi)
  //           // println("This is the real answer ************"+c.io.mosi.peek())
  //           c.clock.step(1)
  //           count += 1
  //       }
  //   }
  // }

  "Spi" in {
    implicit val config = TilelinkConfig()
    implicit val spiConfig = Config()
    test(new Spi()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.dataReq.poke("b10111011101110111011101110111011".U)
      c.io.byteLane.poke("b1111".U)
      c.io.isWrite.poke(true.B)
      c.io.valid.poke(true.B)

      c.clock.step(5)

      
      c.io.dataReq.poke("b11111110000000001111111111000000".U)
      c.io.byteLane.poke("b1111".U)
      c.io.isWrite.poke(true.B)
      c.io.valid.poke(true.B)

      var count = 1
      while(count != 2000) {
          val mosi = c.io.mosi.peek()
          c.io.miso.poke(mosi)
          // println("This is the real answer ************"+c.io.mosi.peek())
          c.clock.step(1)
          count += 1
      }






    //   c.clock.step(5)
    //   c.io.valid.poke(true.B)
    //   c.io.addrReq.poke(0.U)
    //   c.io.dataReq.poke("b1010101010101010101010100001101".U)
    //   c.io.byteLane.poke("b1111111111111111111111111111111".U)
    //   c.io.isWrite.poke(true.B)
    //   c.clock.step(1)
    // //   c.io.valid.poke(true.B)
    // //   c.clock.step(5)
    //   c.io.valid.poke(true.B)
    //   c.io.addrReq.poke(0.U)
    //   c.io.dataReq.poke("b1111100111100000000001111111111".U)
    //   c.io.byteLane.poke("b1111111111111111111111111111111".U)
    //   c.io.isWrite.poke(true.B)
    //   c.clock.step(1)
    //   c.io.valid.poke(false.B)

      // c.clock.step(900)
    }
  }
}