(
SynthDef("string-sect", {
	arg freq=220, vol=1, attack=0.3, sustain=1.0, release=0.3, gate=1.0;

	var out, env, sound;
	env = Env.asr(attackTime: attack, sustainLevel: sustain, releaseTime: release, curve: -4);
	sound = LPF.ar((Mix.new([Pulse.ar(freq: freq), VarSaw.ar(freq: freq, width:0)]) * 0.3), freq: 2000);

	out = sound * EnvGen.kr(envelope: env, gate: gate, levelScale: vol);
	OffsetOut.ar([0, 1], out);
}
)
).add;

a=Synth("string-sect", ["freq", 493.88])

a.set("gate", 0)
