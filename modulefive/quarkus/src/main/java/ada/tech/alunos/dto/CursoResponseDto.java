package ada.tech.alunos.dto;

import ada.tech.alunos.model.Curso;
import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDto {
    private int id;
    private String nome;

    public static CursoResponseDto from (Curso curso) {
        final CursoResponseDtoBuilder response = new CursoResponseDtoBuilder();
        response.id = curso.getId();
        response.nome = curso.getNome();
        return response.build();
    }
}
