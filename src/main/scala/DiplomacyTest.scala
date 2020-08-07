import chipsalliance.rocketchip.config.Config
import chisel3._
import chisel3.internal.sourceinfo.SourceInfo
import chisel3.stage.ChiselStage
import freechips.rocketchip.config.Parameters
import freechips.rocketchip.diplomacy._

class DummyConfig extends Config((_,_,_) => {case a => a})

case class BundleParams(width: Int)
case class EmptyParams()

object DummyNodeImp extends SimpleNodeImp[BundleParams, EmptyParams, BundleParams, UInt] {
  def edge(pd: BundleParams, pu: EmptyParams, p: Parameters, sourceInfo: SourceInfo) = new BundleParams(pd.width)
  def bundle(e: BundleParams) = UInt(e.width.W)
  def render(e: BundleParams) = RenderedEdge("blue", s"width = ${e.width}")
}

class TestHarness()(implicit p: Parameters) extends LazyModule {

  val src = new SourceNode(DummyNodeImp)(Seq(BundleParams(3)))
  val sink = new SinkNode(DummyNodeImp)(Seq(EmptyParams()))
  sink := src

  lazy val module = new LazyModuleImp(this) {
    println("hello")
  }
}

object DiplomacyTest extends App {
  implicit val p: Parameters = new DummyConfig

  println((new ChiselStage).emitVerilog(
    LazyModule(new TestHarness()).module,
    annotations = Seq(chisel3.stage.PrintFullStackTraceAnnotation)
  ))
}