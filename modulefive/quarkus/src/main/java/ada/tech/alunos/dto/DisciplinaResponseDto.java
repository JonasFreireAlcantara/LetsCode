package ada.tech.alunos.dto;

import ada.tech.alunos.model.Aluno;
import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResponseDto {
    private int id;
    private String nome;

    public static DisciplinaResponseDto from (Aluno aluno) {
        final DisciplinaResponseDtoBuilder response = new DisciplinaResponseDtoBuilder();
        response.id = aluno.getId();
        response.nome = aluno.getNome();
        return response.build();
    }
}