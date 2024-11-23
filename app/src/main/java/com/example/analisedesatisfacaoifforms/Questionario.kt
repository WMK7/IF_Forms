package com.example.analisedesatisfacaoifforms

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.analisedesatisfacaoifforms.data_class.Resposta
import com.example.analisedesatisfacaoifforms.databinding.ActivityQuestionarioBinding


class Questionario : AppCompatActivity() {
    private var respostas: MutableList<Resposta> = mutableListOf()

    private lateinit var binding: ActivityQuestionarioBinding

    private val questoes = arrayOf(
        //Tangibilidade 0
        //1
        "Quanto ao curso Técnico em Secretariado integrado ao nível médio do campus Rondonópolis " +
                "deveria ter equipamentos modernos para o uso dos alunos. ",
        //2
        "Quanto as suas instalações físicas do ambiente escolar do IFMT campus Rondonópolis deveria " +
                "ser visualmente atrativo.",
        //3
        "Quanto aos servidores deveriam estar vestidos e asseados de modo apresentável e" +
                " adequado ao ambiente escolar.",
        //4
        "Quanto as aparências das instalações físicas do" +
                " IFMT campus Rondonópolis deveria estar conservada.",
        //5
        "Quanto ao corpo docente aparenta ser suficiente e adequado para atuarem no curso Técnico " +
                "em Secretariado integrado ao nível médio do IFMT campus Rondonópolis.",

        //Confiabilidade 6
        //6
        "Quando a instituição (Ensino, pesquisa, extensão e gestão) promete fazer algo em " +
                "certo tempo, deveriam fazê-lo.",
        //7
        "Quando os discentes têm algum problema com a Instituição (Ensino, pesquisa, extensão" +
                " e gestão) o IFMT campus Rondonópolis deveria ser solidário e deixá-los seguros.",
        //8
        "Quanto a Instituição (Ensino, pesquisa, extensão e a gestão) deveria ser de confiança.",
        //9
        "Quanto aInstituição (Ensino, pesquisa, extensão e a gestão) deveria fornecer o serviço" +
                " no tempo prometido.",
        //10
        "Quanto a Instituição (Ensino, pesquisa, extensão e a gestão) deveria ser confiável.",

        //Responsabilidade 11
        //11
        "É de se esperar que a instituição informasse aos discentes exatamente quando os " +
                "procedimentos administrativos e pedagógicos fossem executados.",
        //12
        "É razoável esperar por uma disponibilidade imediata dos servidores (docentes e técnicos" +
                " administrativos) da Instituição.",
        //13
        "Quantos os servidores (docentes e técnicos administrativos) da instituição estão sempre " +
                "disponíveis em ajudar os discentes.",
        //14
        "É normal que os servidores (docentes e técnicos administrativos) estejam muito ocupados " +
                "em responder prontamente aos pedidos dos discentes.",

        //Garantia 15
        //15
        "Quanto aos discentes deveriam acreditar nos servidores (docentes e técnicos administrativos)" +
                " da Instituição.",
        //16
        "Quanto aos discentes deveriam se sentir seguros tanto nos aspectos do Ensino-aprendizagem" +
                " quanto com os processos administrativos e pedagógicos da instituição.",
        //17
        "Quantos aos servidores (docentes e técnicos administrativos) da Instituição deveriam " +
                "ser educados e cordiais.",
        //18
        "Quanto os servidores (docentes e técnicos administrativos) deveriam obter suporte adequado " +
                "do superior hierárquico para realizar as suas tarefas de forma adequada.",

        //Empatia 18
        //19
        "É de se esperar, que a Instituição desse, atenção individualizada aos discentes.",
        //20
        "É de se esperar que os servidores (docentes e técnicos administrativos) dê atenção " +
                "personalizada aos discentes.",
        //21
        "É provável de se esperar que os servidores (docentes e técnicos administrativos) saibam " +
                "quais são as necessidades dos discentes.",
        //22
        "É provável de se esperar que a Instituição tenha como objetivo, as expectativas " +
                "dos discentes.",
        //23
        "É de se esperar que o horário de atendimento fosse conveniente para todos os discentes.",
    )

    private var indiceQuestao = arrayOf(
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10",
        "11", "12", "13", "14",
        "15", "16", "17", "18",
        "19", "20", "21", "22",
        "23"
    )

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val voltar = binding.imageView3

        voltar.setOnClickListener {
            val intent = Intent(this, TelaSalaCoferencia::class.java)
            startActivity(intent)
        }

        binding.btProximoQuestionario.setOnClickListener {
            avancarQuestionario()
        }

        binding.txtTextoQuestionario.text = questoes[currentQuestionIndex]
        binding.txtwNumeroQuestionario.text = indiceQuestao[currentQuestionIndex]
        atualizarTitulo()
    }

    private fun avancarQuestionario() {
        if (currentQuestionIndex < questoes.size - 1) {
            val radioButtonRealCheckedId = binding.radioGroupReal.getCheckedRadioButtonId();
            val radioButtonEspecCheckedId = binding.radioGroupEspec.getCheckedRadioButtonId();

            if (radioButtonRealCheckedId > -1 && radioButtonEspecCheckedId > -1) {
                val selectedRadioButtonReal = findViewById<RadioButton>(radioButtonRealCheckedId)
                val selectedRadioButtonEspec = findViewById<RadioButton>(radioButtonEspecCheckedId)

                val selectedTextReal = selectedRadioButtonReal.text.toString()
                val selectedTextEspec = selectedRadioButtonEspec.text.toString()

                respostas.add(
                    Resposta(
                        currentQuestionIndex,
                        selectedTextReal.toInt(),
                        selectedTextEspec.toInt()
                    )
                );

                currentQuestionIndex++
                binding.txtTextoQuestionario.text = questoes[currentQuestionIndex]
                binding.txtwNumeroQuestionario.text = indiceQuestao[currentQuestionIndex]

                binding.radioGroupReal.clearCheck()
                binding.radioGroupEspec.clearCheck()

                atualizarTitulo()
            }
        } else {
            val intent = Intent(this, TelaApresentaca::class.java)
            startActivity(intent)
            Handler(Looper.getMainLooper()).postDelayed({
                finish()
            }, 3000)
            binding.btProximoQuestionario.isEnabled = false
            finish()
        }
    }

    private fun atualizarTitulo() {
        when (currentQuestionIndex) {
            in 0..4 -> binding.txtTitulo.text = "Tangibilidade"
            in 5..9 -> binding.txtTitulo.text = "Confiabilidade"
            in 10..13 -> binding.txtTitulo.text = "Responsabilidade"
            in 14..17 -> binding.txtTitulo.text = "Garantia"
            in 18..22 -> binding.txtTitulo.text = "Empatia"
        }
        binding.txtwNumeroQuestionario.text = (currentQuestionIndex + 1).toString()
    }

}